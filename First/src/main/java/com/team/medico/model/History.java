package com.team.medico.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "history")

public class History {
	
	
		@Id
		@Column(name = "email_id")
		private String emailId;
		@Column(name = "disease_type")
		private String diseaseType;
		@Column(name = "start_month")
		private String startMonth;
		@Column(name = "time_period_months")
		private double timePeriodMonths;
		@Column(name="previous_doctor")
		private String previousDoctor;
		@OneToOne
		@JoinColumn(name="email_id")
		private Patient patient;
		
		public History() {
			super();
			// TODO Auto-generated constructor stub
		
}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public String getDiseaseType() {
			return diseaseType;
		}

		public void setDiseaseType(String diseaseType) {
			this.diseaseType = diseaseType;
		}

		public String getStartMonth() {
			return startMonth;
		}

		public void setStartMonth(String startMonth) {
			this.startMonth = startMonth;
		}

		public double getTimePeriodMonths() {
			return timePeriodMonths;
		}

		public void setTimePeriodMonths(double timePeriodMonths) {
			this.timePeriodMonths = timePeriodMonths;
		}

		public String getPreviousDoctor() {
			return previousDoctor;
		}

		public void setPreviousDoctor(String previousDoctor) {
			this.previousDoctor = previousDoctor;
		}


		@Override
		public String toString() {
			return "History [emailId=" + emailId + ", diseaseType=" + diseaseType + ", startMonth=" + startMonth
					+ ", timePeriodMonths=" + timePeriodMonths + ", previousDoctor=" + previousDoctor
					+  "]";
		}
		
}
