Feature: Facebook sign up

@P1 @Regression
Scenario Outline: I am able to sign up for facebook

Given enter first name "<fname>"
Given enter last name "<lname>"
Given enter email "<email>"
When enter password "<pw>"
When select month "<m>"
When select day "<d>"
When select year "<y>"
And Select gender "<gender>"
And Click on Create Account
And Print error message

Examples:
		|fname|lname|email|pw|m|d|y|gender|
		|John|King|aa@gmail.com|laadf23|Mar|11|1992|//input[@value='1']|
		|Sam|Hen|aa@gmail.com|la12kdflk|Jan|12|1982|//input[@value='2']|
#		|Jenny|Carlos|aa@gmail.com|la12kdflk|Feb|13|1973|//input[@value='1']|
#		|Carson|Wentz|e3a@gmail.com|la12kdflk|Jun|10|1994|//input[@value='2']|
		
		
@P1		
Scenario Outline: I am not able able to sign up for facebook

Given typein first name "<fname>" and "<lname>"
Given enter email "<email>"
When enter password "<pw>"
When select month "<m>"
When select day "<d>"
When select year "<y>"
And Select gender "<gender>"
And Click on Create Account
And Print error message
	
Examples:
		|fname|lname|email|pw|m|d|y|gender|
		|Steve|Astle|aa@gmail.com|laadf23|Mar|11|1992|//input[@value='1']|
#		|Sam|Hen|aa@gmail.com|la12kdflk|Jan|12|1982|//input[@value='2']|
#		|Jenny|Carlos|aa@gmail.com|la12kdflk|Feb|13|1973|//input[@value='1']|
#		|Carson|Wentz|e3a@gmail.com|la12kdflk|Jun|10|1994|//input[@value='2']|