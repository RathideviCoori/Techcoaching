Feature: Belly

Scenario Outline: Calaculate Energy charges up for slab 50.
Given I am on the EbillCalculator application
When I enter the unit of consumption as <units>
Then Application calculate Energy Charges as <energycharges>
Examples:
   |units|energycharges|
   |50	 |202.50			 |
   |45	 |182.25			 |
   |0    |0            |
   
   
Scenario Outline: Calaculate FCA charges up for slab 50.
Given I am on the EbillCalculator application
When I enter the unit of consumption as <units>
Then Application calculate FCA Charges as <fcacharges>
Examples: 
   |units|fcacharges|
   |50	 |6.5		    |
   |45	 |5.85			|
   |0    |0         |
   
Scenario Outline: Calaculate Duty charges up for slab 50.
Given I am on the EbillCalculator application
When I enter the unit of consumption as <units>
Then Application calculate Duty Charges as <dutycharges>
Examples: 
   |units|dutycharges|
   |50	 |5.09		   |
   |45	 |4.58	     |
   |0    |0          |
   
Scenario Outline: Calculate Electricty Bill for Slab 50
Given I am on the EbillCalculator application
When I enter the unit of consumption as <units>
Then Application calculate Electricity Bill as <electricitybill>
Examples: 
   |units|electricitybill|
   |50	 |214.09		     |
   |45	 |192.68         |
   |0    |0              |

Scenario Outline: Calaculate Energy charges up for slab 51 to 150.
Given I am on the EbillCalculator application
When I enter the unit of consumption as <units>
Then Application calculate Energy Charges as <energycharges> for slab two
Examples:
   |units|energycharges|
   |51	 |207.45			 |
   |150	 |697.5			   |
   |88   |390.6        |
   |123  |563.85       |
   
Scenario Outline: Calaculate FCA charges up for slab 51 to 150.
Given I am on the EbillCalculator application
When I enter the unit of consumption as <units>
Then Application calculate FCA Charges as <fcacharges> for slab two
Examples: 
   |units|fcacharges|
   |51	 |6.63		  |
   |150	 |19.5		  |
   |88   |11.44     |
   |123  |15.99     |
   
Scenario Outline: Calaculate Duty charges up for slab 51 to 150.
Given I am on the EbillCalculator application
When I enter the unit of consumption as <units>
Then Application calculate Duty Charges as <dutycharges> for slab two
Examples: 
   |units|dutycharges|
   |51	 |5.22	     |
   |150	 |18.645     |
   |88   |10.2378    |
   |123  |14.9838    |

Scenario Outline: Calculate Electricty Bill for Slab 51 to 150
Given I am on the EbillCalculator application
When I enter the unit of consumption as <units>
Then Application calculate Electricity Bill as <electricitybill> for slab two
Examples: 
  |units|electricitybill| 
	|51	  |219.3          |
  |150	|735.645        |
  |88   |412.2778       |
  |123  |594.8238       |