package com.team.medico.service;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.HmacUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.time.Instant;
import java.time.format.DateTimeParseException;
@Component
public class GenerateToken {

    public static final String PROVISION_TOKEN = "provision";
    private static final long EPOCH_SECONDS = 62167219200l;
    private static final String DELIM = "\0";


    public static String generateProvisionToken(String key, String jid, String expires, String vcard) throws NumberFormatException {
        String payload = String.join(DELIM, PROVISION_TOKEN, jid, expires, vcard);
        return new String(Base64.encodeBase64(
                (String.join(DELIM, payload, HmacUtils.hmacSha384Hex(key, payload))).getBytes()
        ));
    }

    public static String calculateExpiry(String expires) throws NumberFormatException {
        long expiresLong = 0l;
        long currentUnixTimestamp = System.currentTimeMillis() / 1000;
        expiresLong = Long.parseLong(expires);
        return ""+(EPOCH_SECONDS + currentUnixTimestamp + expiresLong);
    }

    private static void printUsageAndExit() {
        System.out.println();
        System.out.println("This script will generate a provision login token from a developer key");
        System.out.println("Options:");
        System.out.println("--key           Developer key supplied with the developer account");
        System.out.println("--appID         ApplicationID supplied with the developer account");
        System.out.println("--userName      Username to generate a token for");
        System.out.println("--vCardFile     Path to the XML file containing a vCard for the user (optional)");
        System.out.println("--expiresInSecs Number of seconds the token will be valid");
        System.out.println("--expiresAt     Time at which the token will expire ex: (2055-10-27T10:54:22Z) can be used instead of expiresInSecs");
        System.out.println();
        System.exit(1);
    }

    public String getToken(String user) {

        String key = "e3a6aa2e8d384decbf2a4c8683f07a78";
        String appID = "85abaf.vidyo.io";
        String userName = user;
        String vCardFilePath = null;    // optional
        String expiresInSeconds = "1800"; // required if expiresAt is not set
        String expiresAt = null;        // optional; used only if expiresInSeconds is not set

        

        // calculate expiration
        String expires = "";
        if (expiresInSeconds != null) {
        	expires = calculateExpiry(expiresInSeconds);
        } else {
        	Instant instant = null;
        	if (expiresAt != null) {
        		try {
					instant = Instant.parse(expiresAt);
				} catch (DateTimeParseException e) {
					System.out.println("Invalid date format. Ex: (2055-10-27T10:54:22Z)");
					printUsageAndExit();
				}
        	} else {
        		System.out.println("expiresInSecs or expiresAt not set");
                printUsageAndExit();
        	}
        	
        	expires = String.valueOf(EPOCH_SECONDS + instant.getEpochSecond());
        }
        
        // vCardFile is optional
        String vCard = "";
        if (vCardFilePath != null) {
            File vCardFile = new File(vCardFilePath);
            if (!vCardFile.exists()) {
                System.out.println("File not found: " + vCardFilePath);
                System.exit(1);
            }
            try {
                vCard = new String(Files.readAllBytes(vCardFile.toPath()));
            } catch (IOException ioe) {
                System.out.println("Failed to read file: " + vCardFilePath);
                System.exit(1);
            }
        }

        try {
            System.out.println("Setting key           :  " + key);
            System.out.println("Setting appID         :  " + appID);
            System.out.println("Setting userName      :  " + userName);
            System.out.println("Setting vCardFile     :  " + vCardFilePath);
            System.out.println("Setting expiresInSecs :  " + expiresInSeconds);
            System.out.println("Setting expiresAt     :  " + expiresAt);
            System.out.println("Generating Token...");
            //System.out.println(generateProvisionToken(key, userName + "@" + appID, expires, vCard))
            String tt = generateProvisionToken(key, userName + "@" + appID, expires, vCard);
            System.out.println(tt);
            String[] arr =tt.split("==",2);
            return arr[0];
        } catch (NumberFormatException nfe) {
            System.out.println("Failed to parse expiration time: " + expires);
            System.exit(1);
        }
        return null;
    }
}

