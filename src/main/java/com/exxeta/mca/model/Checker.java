package com.exxeta.mca.model;

public class Checker {
	
	public static boolean equals ( Position p1, Position p2 ) {
		
		if ( p1 == p2 ) return true;
		
		if ( p1 == null || p2 == null ) {
			return false;
		}
		
		if ( p1.getCOBDate()  		!=      p2.getCOBDate() )		 return false;
		if ( p1.getOrgID()    		!=      p2.getOrgID() ) 		 return false;
		if ( p1.getBu()       		!=      p2.getBu() )			 return false;
		
		if ( p1.getActCd()==null && p2.getActCd()!=null || p1.getActCd()!=null && p2.getActCd()==null ||
			 p1.getActCd()     !=null  && p2.getActCd()!=null         && !p1.getActCd().equals(p2.getActCd()) )		  return false;
		
		if ( p1.getCurrency()==null && p2.getCurrency()!=null || p1.getCurrency()!=null && p2.getCurrency()==null ||
			 p1.getCurrency()     !=null  && p2.getCurrency()!=null      && !p1.getCurrency().equals(p2.getCurrency()) )	  return false;
		
		if ( p1.getAmount()==null && p2.getAmount()!=null || p1.getAmount()!=null && p2.getAmount()==null ||
			 p1.getAmount()       !=null  && p2.getAmount()!=null        && !p1.getAmount().equals(p2.getAmount()) )		  return false;
		
		if ( p1.getblcd_currency()==null && p2.getblcd_currency()!=null || p1.getblcd_currency()!=null && p2.getblcd_currency()==null ||
			 p1.getblcd_currency()!=null  && p2.getblcd_currency()!=null && !p1.getblcd_currency().equals(p2.getblcd_currency()) ) return false;
		
		if ( p1.getblcd_amount()==null && p2.getblcd_amount()!=null || p1.getblcd_amount()!=null && p2.getblcd_amount()==null ||
			 p1.getblcd_amount()  !=null  && p2.getblcd_amount()!=null   && !p1.getblcd_amount().equals(p2.getblcd_amount()) )   return false;
		
		return true;
		
	}

}
