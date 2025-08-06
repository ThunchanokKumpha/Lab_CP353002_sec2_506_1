package com.example.shared;

import org.springframework.stereotype.Component;

@Component
public class CompanyInformation {
		private String name;
		private String telephone;
		
		public CompanyInformation(String name, String telephone) {
			super();
			this.name = name;
			this.telephone = telephone;
		}

		
		
		public CompanyInformation() {
			super();
			// TODO Auto-generated constructor stub
		}


		public String getName() {
			return this.name;
		}



		public void setName(String name) {
			this.name = name;
		}



		public String getTelephone() {
			return this.telephone;
		}



		public void setTelephone(String telephone) {
			this.telephone = telephone;
		}




		public void printCompanyInfo() {
			System.out.println("Company: "+ name + "Tel: "+ telephone);
		}
		


		
}
