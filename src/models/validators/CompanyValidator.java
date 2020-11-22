package models.validators;

import java.util.ArrayList;
import java.util.List;

import models.Company;




    public class CompanyValidator {
        public static List<String> validate(Company c) {
            List<String> errors = new ArrayList<String>();

            String company_name_error = _validateCompany_name(c.getCompany_name());
            if(!company_name_error.equals("")) {
                errors.add(company_name_error);
            }

            String president_error = _validatePresident(c.getPresident());
            if(!president_error.equals("")) {
                errors.add(president_error);
            }

            return errors;
        }

        private static String _validateCompany_name(String compnay_name) {
            if(compnay_name == null || compnay_name.equals("")) {
                return "企業名を入力してください。";
                }

            return "";
        }

        private static String _validatePresident(String president) {
            if(president == null || president.equals("")) {
                return "代表者名を入力してください。";
                }

            return "";
        }
    }