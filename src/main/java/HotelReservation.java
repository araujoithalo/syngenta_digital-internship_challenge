public class HotelReservation {

    /*
	 * User = [Regular, Reward]; Stars = [Lakewood: 3, Bridgewood: 4, Ridgewood: 5]
	 */


    public String getCheapestHotel (String input) {

        input.toLowerCase();

		String hotel = "";
		int count_weekdays = 0, count_weekends = 0, lakewood_total = 0, bridgewood_total = 0, ridgewood_total = 0;

		// the strategy to define if it's regular or reward is checking string.charAt(2)
		// so if it's G means reGular, once it's W means reWard

		if (input.charAt(2) == 'g') { // Case 1: reGular member

			// String check
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == '(') {

					// week days: 'm' for Monday, 't' for Tuesday and Thursday, 'w' for Wednesday,
					// 'f' for Friday
					if (input.charAt(i + 1) == 'm' || input.charAt(i + 1) == 'w' || input.charAt(i + 1) == 'f'
							|| input.charAt(i + 1) == 't') {
						count_weekdays += 1;

						// weekends: 's' for Saturday and Sunday
					} else if (input.charAt(i + 1) == 's') {
						count_weekends += 1;
					}
				}
			}

			// calculate total value to be paid at the and in order to check lowest price
			lakewood_total = count_weekdays * 110 + count_weekends * 90;
			bridgewood_total = count_weekdays * 160 + count_weekends * 60;
			ridgewood_total = count_weekdays * 220 + count_weekends * 150;

			if (lakewood_total < bridgewood_total && lakewood_total < ridgewood_total) { // Lakewood cheaper
				hotel = hotel + "Lakewood";
			} else if (bridgewood_total < lakewood_total && bridgewood_total < ridgewood_total) { // Bridgewood cheaper
				hotel = hotel + "Bridgewood";
			} else if (ridgewood_total == lakewood_total || ridgewood_total == bridgewood_total) { // Choosing by higher
																									// // classification
				hotel = hotel + "Ridgewood";
			} else if (bridgewood_total == lakewood_total) {// Choosing by higher classification
				hotel = hotel + "Bridgewood";
			} else {
				hotel = hotel + "Ridgewood"; // Ridgewood cheaper
			}

		} else if (input.charAt(2) == 'w') {// Case 2: reWard member

			// String check
			for (int i = 0; i < input.length(); i++) {
				if (input.charAt(i) == '(') {

					// week days: 'm' for Monday, 't' for Tuesday and Thursday, 'w' for Wednesday,
					// 'f' for Friday
					if (input.charAt(i + 1) == 'm' || input.charAt(i + 1) == 'w' || input.charAt(i + 1) == 'f'
							|| input.charAt(i + 1) == 't') {
						count_weekdays += 1;

						// weekends: 's' for Saturday and Sunday
					} else if (input.charAt(i + 1) == 's') {
						count_weekends += 1;
					}
				}
			}

			// calculate total value to be paid at the and in order to check lowest price
			lakewood_total = count_weekdays * 80 + count_weekends * 80;
			bridgewood_total = count_weekdays * 110 + count_weekends * 50;
			ridgewood_total = count_weekdays * 100 + count_weekends * 40;

			if (lakewood_total < bridgewood_total && lakewood_total < ridgewood_total) { // Lakewood cheaper
				hotel = hotel + "Lakewood";
			} else if (bridgewood_total < lakewood_total && bridgewood_total < ridgewood_total) { // Bridgewood cheaper
				hotel = hotel + "Bridgewood";
			} else if (ridgewood_total == lakewood_total || ridgewood_total == bridgewood_total) { // Choosing by higher
																									// // //
																									// classification
				hotel = hotel + "Ridgewood";
			} else if (bridgewood_total == lakewood_total) {// Choosing by higher classification
				hotel = hotel + "Bridgewood";
			} else {
				hotel = hotel + "Ridgewood"; // Ridgewood cheaper
			}

		} else {
			hotel = hotel + "Erro";
		}

		return hotel;
    }
}
