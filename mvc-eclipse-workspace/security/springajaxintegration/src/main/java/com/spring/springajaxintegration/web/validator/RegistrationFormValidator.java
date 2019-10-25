package com.spring.springajaxintegration.web.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("example3/validate")
public class RegistrationFormValidator {

	private Pattern pattern;
	private Matcher matcher;

	/**
	 * Pattern to validate email address.
	 */
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	/**
	 * Pattern to validate mobile number of 10 digits
	 */
	private static final String MOBILE_NUMBER_PATTERN = "\\d{10}";

	/**
	 * Pattern to validate postal code of 6 digits
	 */
	private static final String POSTAL_CODE_PATTERN = "\\d{6}";

	/**
	 * ^ # start of the line # # must contain a "#" symbols ( # start of group
	 * #1 [A-Fa-f0-9]{6} # any strings in the list, with length of 6 | # ..or
	 * [A-Fa-f0-9]{30} # any strings in the list, with length of 30 ) # end of
	 * group #1 $ # end of the line
	 */
	public static final String PASSWORD_PATTERN = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,30})";

	@RequestMapping(value = "checkNameForEmpty", method = RequestMethod.POST)
	public @ResponseBody String checkNameForEmpty(
			@RequestParam("name") String name) {
		if (name.trim().isEmpty() || name.equals("")) {
			return "EMPTY";
		} else {
			return "NOT_EMPTY";
		}
	}

	@RequestMapping(value = "checkPasswordForEmpty", method = RequestMethod.POST)
	public @ResponseBody String checkPasswordForEmpty(
			@RequestParam("password") String password) {
		if (password.trim().isEmpty() || password.equals("")) {
			return "EMPTY";
		} else {
			return "NOT_EMPTY";
		}
	}

	@RequestMapping(value = "checkRepeatPasswordForEmpty", method = RequestMethod.POST)
	public @ResponseBody String checkRepeatPasswordForEmpty(
			@RequestParam("repeatPassword") String repeatPassword) {
		if (repeatPassword.trim().isEmpty() || repeatPassword.equals("")) {
			return "EMPTY";
		} else {
			return "NOT_EMPTY";
		}
	}

	@RequestMapping(value = "checkEmailIdForEmpty", method = RequestMethod.POST)
	public @ResponseBody String checkEmailIdForEmpty(
			@RequestParam("emailId") String emailId) {
		if (emailId.trim().isEmpty() || emailId.equals("")) {
			return "EMPTY";
		} else {
			return "NOT_EMPTY";
		}
	}

	@RequestMapping(value = "checkMobileNumberForEmpty", method = RequestMethod.POST)
	public @ResponseBody String checkMobileNumberForEmpty(
			@RequestParam("mobileNumber") String mobileNumber) {
		if (mobileNumber.trim().isEmpty() || mobileNumber.equals("")) {
			return "EMPTY";
		} else {
			return "NOT_EMPTY";
		}
	}

	@RequestMapping(value = "checkStateForEmpty", method = RequestMethod.POST)
	public @ResponseBody String checkStateForEmpty(
			@RequestParam("state") String state) {
		if (state.trim().isEmpty() || state.equals("Select State")) {
			return "EMPTY";
		} else {
			return "NOT_EMPTY";
		}
	}

	@RequestMapping(value = "checkCityForEmpty", method = RequestMethod.POST)
	public @ResponseBody String checkCityForEmpty(
			@RequestParam("city") String city) {
		if (city.trim().isEmpty() || city.equals("Select City")) {
			return "EMPTY";
		} else {
			return "NOT_EMPTY";
		}
	}

	@RequestMapping(value = "checkPostalCodeForEmpty", method = RequestMethod.POST)
	public @ResponseBody String checkPostalCodeForEmpty(
			@RequestParam("postalCode") String postalCode) {
		if (postalCode.trim().isEmpty() || postalCode.equals("")) {
			return "EMPTY";
		} else {
			return "NOT_EMPTY";
		}
	}

	@RequestMapping(value = "checkCountryForEmpty", method = RequestMethod.POST)
	public @ResponseBody String checkCountryForEmpty(
			@RequestParam("country") String country) {
		if (country.trim().isEmpty() || country.equals("Select Country")) {
			return "EMPTY";
		} else {
			return "NOT_EMPTY";
		}
	}

	@RequestMapping(value = "checkMobileNumberForWrongPattern", method = RequestMethod.POST)
	public @ResponseBody String checkMobileNumberForWrongPattern(
			@RequestParam("mobileNumber") String mobileNumber) {

		if (!mobileNumber.equals("") || !mobileNumber.trim().isEmpty()) {
			pattern = Pattern.compile(MOBILE_NUMBER_PATTERN);
			matcher = pattern.matcher(mobileNumber);
			if (!matcher.matches()) {
				return "WRONG_PATTERN";
			} else {
				return "CORRECT_PATTERN";
			}
		}
		return "0";
	}

	@RequestMapping(value = "checkPostalCodeForWrongPattern", method = RequestMethod.POST)
	public @ResponseBody String checkPostalCodeForWrongPattern(
			@RequestParam("postalCode") String postalCode) {

		if (!postalCode.equals("") || !postalCode.trim().isEmpty()) {
			pattern = Pattern.compile(POSTAL_CODE_PATTERN);
			matcher = pattern.matcher(postalCode);
			if (!matcher.matches()) {
				return "WRONG_PATTERN";
			} else {
				return "CORRECT_PATTERN";
			}
		}
		return "0";
	}

	@RequestMapping(value = "checkEmailIdForWrongPattern", method = RequestMethod.POST)
	public @ResponseBody String checkEmailIdForWrongPattern(
			@RequestParam("emailId") String emailId) {

		if (!emailId.equals("") || !emailId.trim().isEmpty()) {
			pattern = Pattern.compile(EMAIL_PATTERN);
			matcher = pattern.matcher(emailId);
			if (!matcher.matches()) {
				return "WRONG_PATTERN";
			} else {
				return "CORRECT_PATTERN";
			}
		}
		return "0";
	}

	@RequestMapping(value = "checkPasswordForWrongPattern", method = RequestMethod.POST)
	public @ResponseBody String checkPasswordForWrongPattern(
			@RequestParam("password") String password) {

		if (!password.equals("") || !password.trim().isEmpty()) {
			pattern = Pattern.compile(PASSWORD_PATTERN);
			matcher = pattern.matcher(password);
			if (!matcher.matches()) {
				return "WRONG_PATTERN";
			} else {
				return "CORRECT_PATTERN";
			}
		}
		return "0";
	}

	@RequestMapping(value = "checkRepeatPasswordForEqual", method = RequestMethod.POST)
	public @ResponseBody String checkRepeatPasswordForEqual(
			@RequestParam("password") String password,
			@RequestParam("repeatPassword") String repeatPassword) {

		if (!password.equals("") || !password.trim().isEmpty()
				|| repeatPassword.equals("") || repeatPassword.trim().isEmpty()) {
			
			if (password.equals(repeatPassword)) {
				return "SAME";
			} else {
				return "NOT_SAME";
			}
		}
		return "0";
	}
}