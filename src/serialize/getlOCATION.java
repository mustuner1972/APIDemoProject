package serialize;

import java.util.List;

public class getlOCATION {

        private LOCATION location; // will include "lat": -38.383494 and "lng": 33.427362
        private int accuracy ;
        private String name;
        private String phoneNumber;
        private String address;
        private String webSite;
        private String language;
        private List<String> types; //will include "shoe park" and "shop"

        public LOCATION getLocation() {
            return location;
        }

        public void setLocation(LOCATION location) {
            this.location = location;
        }

        public int getAccuracy() {
            return accuracy;
        }

        public void setAccuracy(int accuracy) {
            this.accuracy = accuracy;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getWebSite() {
            return webSite;
        }

        public void setWebSite(String webSite) {
            this.webSite = webSite;
        }

        public String getLanguage() {
            return language;
        }

        public void setLanguage(String language) {
            this.language = language;
        }

        public List<String> getTypes() {
            return types;
        }

        public void setTypes(List<String> types) {
            this.types = types;
        }
    }