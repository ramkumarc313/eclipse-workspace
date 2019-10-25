$('#countryDetailsForm').submit(function(e) {
		$('#loading').html('<img src="./resources/img/ajax-loader.gif">');
        var country = $('#country').val();
        $.post('./example2/getCountryDetails?country=' + country, function(countryEntity) {
          $('#countryCode').text(countryEntity.countryCode);
          $('#countryName').text(countryEntity.countryName);
          $('#longName').text(countryEntity.longName);
          $('#iso3').text(countryEntity.iso3);
          $('#numCode').text(countryEntity.numCode);
          $('#unNumber').text(countryEntity.unNumber);
          $('#callingCode').text(countryEntity.callingCode);
          $('#cctld').text(countryEntity.cctld);
          $('#loading').html('');
        });
        e.preventDefault(); // prevent actual form submit
});