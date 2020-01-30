package com.rail.core;

 
import org.springframework.core.convert.converter.Converter;
 
public class StationConversion implements Converter<String, Station> {

	@Override
	public Station convert(String from) {
		String[] s = from.split("\\|");
		return new Station(Integer.parseInt(s[0]), Integer.parseInt(s[1]), s[2],s[3]);
	}

}
