package magento.utils;

import org.testng.annotations.DataProvider;

public class RegistrationDataProvider {

    String x = "6";
    @DataProvider(name = "CreateNewCustomerAccount")
    public Object[][] getData() {
        Object[][] data = {
                // Valid combinations
                {"John", "Smith", "simple"+x+"@example.com", "Passw0rd!","Valid combinations"},

                // Invalid combinations
                {"J0hn", "Smith", "simple"+x+"@example.com", "password","Invalid combinations"},
                {"John", "Sm1th", "john.doe"+x+"@.com", "Passw0rd!","Invalid combinations"},
                {"J0hn", "Sm1th", "john.doe"+x+"@.com", "password","Invalid combinations"},

                // Edge cases
                {"J", "X", "edge"+x+"@example.com", "P@$$w0rd","Edge cases"},
                {"Anna-Maria", "Chan-Wong", "edge+case"+x+"@example.com", "Ab#12&Cd","Edge cases"},
                {"Élise", "Müller", "éliśé.müllér"+x+"@example.com", "ñÑ4$%tY","Edge cases"},
                {"Māori", "Brontë", "maori.bronte"+x+"@example.com", "Qw3rTy*9(","Edge cases"},

                // Extremely short and long names, emails, and passwords
                {"A", "Z", "a."+x+"@short.com", "Aa#1234$"},
                {"SupercalifragilisticexpialidociousSupercalifragilisticexpialid", "SupercalifragilisticexpialidociousSupercalifragilisticexpialid",
                        "extremelylongemail"+x+"@example.com", "Ab#12&Cd","Extremely short and long names, emails, and passwords"},
                {"John", "Smith", "extremelylongemailaddressfortestingpurposes"+x+"@example.com", "Passw0rd!","Extremely short and long names, emails, and passwords"},
                {"John", "Smith", "simple"+x+"@example.com", "P@ssw0r","Extremely short and long names, emails, and passwords"}, // 7 characters, assuming 8 required
                {"John", "Smith", "simple"+x+"@example.com", "Ab#12&Cd3E@56fGh78iJ&Kl90mN^oP12qR34sT56uVw*78","Extremely short and long names, emails, and passwords"}, // 50 characters
        };
        return data;
    }
}
