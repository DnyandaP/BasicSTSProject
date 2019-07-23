package com.team.medico.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;



@Entity
@Table(name = "preferred_language")
public class PreferredLanguage {

		@Id
		@Column(name = "language_id")
		private String languageId;
		
		@Column(name = "pref_language")
		private String prefLanguage;
		@ManyToMany(mappedBy = "preferredLanguage")
		private Set<User> user = new HashSet<User>();
		public String getLanguageId() {
			return languageId;
		}
		public void setLanguageId(String languageId) {
			this.languageId = languageId;
		}
		public String getPrefLanguage() {
			return prefLanguage;
		}
		public void setPrefLanguage(String prefLanguage) {
			this.prefLanguage = prefLanguage;
		}
		public Set<User> getUser() {
			return user;
		}
		public void setUser(Set<User> user) {
			this.user = user;
		}
		
		
}

