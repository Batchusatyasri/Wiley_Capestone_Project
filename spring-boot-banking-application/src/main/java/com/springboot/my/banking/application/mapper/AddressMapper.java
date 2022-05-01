
package com.springboot.my.banking.application.mapper;

import com.springboot.my.banking.application.model.Address;

public class AddressMapper {

	public static Address processAddress(String address) {
		String[] addressArray = address.split(",");
		return new Address(addressArray[0].trim(), addressArray[1].trim(), addressArray[2].trim(),
				addressArray[3].trim(), Integer.parseInt(addressArray[0].trim()));
	}

}
