/*
 * Copyright 2015 Karl Bennett
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package example.rest.spring.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;

/**
 * A simple address class that is an aggregate of the {@link User} class.
 *
 * @author Karl Bennett
 */
@Entity
public class Address extends Id implements Serializable {

    @Column
    private Integer number;

    @Column
    private String street;

    @Column
    private String suburb;

    @Column
    private String city;

    @Column
    private String postcode;

    public Address() {
    }

    public Address(Integer number, String street, String suburb, String city, String postcode) {
        this(null, number, street, suburb, city, postcode);
    }

    public Address(Address address) {
        this(address.getId(), address.getNumber(), address.getStreet(), address.getSuburb(), address.getCity(),
                address.getPostcode());
    }

    public Address(Long id, Integer number, String street, String suburb, String city, String postcode) {
        super(id);
        setNumber(number);
        setStreet(street);
        setSuburb(suburb);
        setCity(city);
        setPostcode(postcode);
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getSuburb() {
        return suburb;
    }

    public void setSuburb(String suburb) {
        this.suburb = suburb;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public boolean equals(Object object) {

        if (this == object) {
            return true;
        }
        if (!(object instanceof Address)) {
            return false;
        }
        if (!super.equals(object)) {
            return false;
        }

        final Address that = (Address) object;

        if (city != null ? !city.equals(that.city) : that.city != null) {
            return false;
        }
        if (number != null ? !number.equals(that.number) : that.number != null) {
            return false;
        }
        if (postcode != null ? !postcode.equals(that.postcode) : that.postcode != null) {
            return false;
        }
        if (street != null ? !street.equals(that.street) : that.street != null) {
            return false;
        }
        if (suburb != null ? !suburb.equals(that.suburb) : that.suburb != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {

        int result = super.hashCode();
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (suburb != null ? suburb.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (postcode != null ? postcode.hashCode() : 0);

        return result;
    }

    @Override
    public String toString() {
        return "Address {" +
              /**/"id = " + getId() +
                ", number = " + number +
                ", street = '" + street + '\'' +
                ", suburb = '" + suburb + '\'' +
                ", city = '" + city + '\'' +
                ", postcode = '" + postcode + '\'' +
                '}';
    }
}
