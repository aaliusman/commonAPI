$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/java/Feature/Sprint 1/Fbsignup.feature");
formatter.feature({
  "line": 1,
  "name": "Facebook sign up",
  "description": "",
  "id": "facebook-sign-up",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 4,
  "name": "I am able to sign up for facebook",
  "description": "",
  "id": "facebook-sign-up;i-am-able-to-sign-up-for-facebook",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@P1"
    },
    {
      "line": 3,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "enter first name \"\u003cfname\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "enter last name \"\u003clname\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "enter email \"\u003cemail\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "enter password \"\u003cpw\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "select month \"\u003cm\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "select day \"\u003cd\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "select year \"\u003cy\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Select gender \"\u003cgender\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "Click on Create Account",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "Print error message",
  "keyword": "And "
});
formatter.examples({
  "line": 17,
  "name": "",
  "description": "",
  "id": "facebook-sign-up;i-am-able-to-sign-up-for-facebook;",
  "rows": [
    {
      "cells": [
        "fname",
        "lname",
        "email",
        "pw",
        "m",
        "d",
        "y",
        "gender"
      ],
      "line": 18,
      "id": "facebook-sign-up;i-am-able-to-sign-up-for-facebook;;1"
    },
    {
      "cells": [
        "John",
        "King",
        "aa@gmail.com",
        "laadf23",
        "Mar",
        "11",
        "1992",
        "//input[@value\u003d\u00271\u0027]"
      ],
      "line": 19,
      "id": "facebook-sign-up;i-am-able-to-sign-up-for-facebook;;2"
    },
    {
      "cells": [
        "Sam",
        "Hen",
        "aa@gmail.com",
        "la12kdflk",
        "Jan",
        "12",
        "1982",
        "//input[@value\u003d\u00272\u0027]"
      ],
      "line": 20,
      "id": "facebook-sign-up;i-am-able-to-sign-up-for-facebook;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 19,
  "name": "I am able to sign up for facebook",
  "description": "",
  "id": "facebook-sign-up;i-am-able-to-sign-up-for-facebook;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@P1"
    },
    {
      "line": 3,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "enter first name \"John\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "enter last name \"King\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "enter email \"aa@gmail.com\"",
  "matchedColumns": [
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "enter password \"laadf23\"",
  "matchedColumns": [
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "select month \"Mar\"",
  "matchedColumns": [
    4
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "select day \"11\"",
  "matchedColumns": [
    5
  ],
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "select year \"1992\"",
  "matchedColumns": [
    6
  ],
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Select gender \"//input[@value\u003d\u00271\u0027]\"",
  "matchedColumns": [
    7
  ],
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "Click on Create Account",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "Print error message",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "John",
      "offset": 18
    }
  ],
  "location": "GuiStepDefinition.enterfname(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "King",
      "offset": 17
    }
  ],
  "location": "GuiStepDefinition.enterlname(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "aa@gmail.com",
      "offset": 13
    }
  ],
  "location": "GuiStepDefinition.enteremail(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "laadf23",
      "offset": 16
    }
  ],
  "location": "GuiStepDefinition.enterpw(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Mar",
      "offset": 14
    }
  ],
  "location": "GuiStepDefinition.slmonth(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "11",
      "offset": 12
    }
  ],
  "location": "GuiStepDefinition.slday(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "1992",
      "offset": 13
    }
  ],
  "location": "GuiStepDefinition.slyear(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "//input[@value\u003d\u00271\u0027]",
      "offset": 15
    }
  ],
  "location": "GuiStepDefinition.clickGender(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "GuiStepDefinition.clickcreatAcnt()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "GuiStepDefinition.printerror()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "line": 20,
  "name": "I am able to sign up for facebook",
  "description": "",
  "id": "facebook-sign-up;i-am-able-to-sign-up-for-facebook;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 3,
      "name": "@P1"
    },
    {
      "line": 3,
      "name": "@Regression"
    }
  ]
});
formatter.step({
  "line": 6,
  "name": "enter first name \"Sam\"",
  "matchedColumns": [
    0
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 7,
  "name": "enter last name \"Hen\"",
  "matchedColumns": [
    1
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 8,
  "name": "enter email \"aa@gmail.com\"",
  "matchedColumns": [
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "enter password \"la12kdflk\"",
  "matchedColumns": [
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "select month \"Jan\"",
  "matchedColumns": [
    4
  ],
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "select day \"12\"",
  "matchedColumns": [
    5
  ],
  "keyword": "When "
});
formatter.step({
  "line": 12,
  "name": "select year \"1982\"",
  "matchedColumns": [
    6
  ],
  "keyword": "When "
});
formatter.step({
  "line": 13,
  "name": "Select gender \"//input[@value\u003d\u00272\u0027]\"",
  "matchedColumns": [
    7
  ],
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "Click on Create Account",
  "keyword": "And "
});
formatter.step({
  "line": 15,
  "name": "Print error message",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Sam",
      "offset": 18
    }
  ],
  "location": "GuiStepDefinition.enterfname(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Hen",
      "offset": 17
    }
  ],
  "location": "GuiStepDefinition.enterlname(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "aa@gmail.com",
      "offset": 13
    }
  ],
  "location": "GuiStepDefinition.enteremail(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "la12kdflk",
      "offset": 16
    }
  ],
  "location": "GuiStepDefinition.enterpw(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Jan",
      "offset": 14
    }
  ],
  "location": "GuiStepDefinition.slmonth(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "12",
      "offset": 12
    }
  ],
  "location": "GuiStepDefinition.slday(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "1982",
      "offset": 13
    }
  ],
  "location": "GuiStepDefinition.slyear(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "//input[@value\u003d\u00272\u0027]",
      "offset": 15
    }
  ],
  "location": "GuiStepDefinition.clickGender(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "GuiStepDefinition.clickcreatAcnt()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "GuiStepDefinition.printerror()"
});
formatter.result({
  "status": "skipped"
});
formatter.scenarioOutline({
  "comments": [
    {
      "line": 21,
      "value": "#\t\t|Jenny|Carlos|aa@gmail.com|la12kdflk|Feb|13|1973|//input[@value\u003d\u00271\u0027]|"
    },
    {
      "line": 22,
      "value": "#\t\t|Carson|Wentz|e3a@gmail.com|la12kdflk|Jun|10|1994|//input[@value\u003d\u00272\u0027]|"
    }
  ],
  "line": 26,
  "name": "I am not able able to sign up for facebook",
  "description": "",
  "id": "facebook-sign-up;i-am-not-able-able-to-sign-up-for-facebook",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 25,
      "name": "@P1"
    }
  ]
});
formatter.step({
  "line": 28,
  "name": "typein first name \"\u003cfname\u003e\" and \"\u003clname\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 29,
  "name": "enter email \"\u003cemail\u003e\"",
  "keyword": "Given "
});
formatter.step({
  "line": 30,
  "name": "enter password \"\u003cpw\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 31,
  "name": "select month \"\u003cm\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "select day \"\u003cd\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 33,
  "name": "select year \"\u003cy\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 34,
  "name": "Select gender \"\u003cgender\u003e\"",
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "Click on Create Account",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "Print error message",
  "keyword": "And "
});
formatter.examples({
  "line": 38,
  "name": "",
  "description": "",
  "id": "facebook-sign-up;i-am-not-able-able-to-sign-up-for-facebook;",
  "rows": [
    {
      "cells": [
        "fname",
        "lname",
        "email",
        "pw",
        "m",
        "d",
        "y",
        "gender"
      ],
      "line": 39,
      "id": "facebook-sign-up;i-am-not-able-able-to-sign-up-for-facebook;;1"
    },
    {
      "cells": [
        "Steve",
        "Astle",
        "aa@gmail.com",
        "laadf23",
        "Mar",
        "11",
        "1992",
        "//input[@value\u003d\u00271\u0027]"
      ],
      "line": 40,
      "id": "facebook-sign-up;i-am-not-able-able-to-sign-up-for-facebook;;2"
    }
  ],
  "keyword": "Examples"
});
formatter.scenario({
  "line": 40,
  "name": "I am not able able to sign up for facebook",
  "description": "",
  "id": "facebook-sign-up;i-am-not-able-able-to-sign-up-for-facebook;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 25,
      "name": "@P1"
    }
  ]
});
formatter.step({
  "line": 28,
  "name": "typein first name \"Steve\" and \"Astle\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 29,
  "name": "enter email \"aa@gmail.com\"",
  "matchedColumns": [
    2
  ],
  "keyword": "Given "
});
formatter.step({
  "line": 30,
  "name": "enter password \"laadf23\"",
  "matchedColumns": [
    3
  ],
  "keyword": "When "
});
formatter.step({
  "line": 31,
  "name": "select month \"Mar\"",
  "matchedColumns": [
    4
  ],
  "keyword": "When "
});
formatter.step({
  "line": 32,
  "name": "select day \"11\"",
  "matchedColumns": [
    5
  ],
  "keyword": "When "
});
formatter.step({
  "line": 33,
  "name": "select year \"1992\"",
  "matchedColumns": [
    6
  ],
  "keyword": "When "
});
formatter.step({
  "line": 34,
  "name": "Select gender \"//input[@value\u003d\u00271\u0027]\"",
  "matchedColumns": [
    7
  ],
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "Click on Create Account",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "Print error message",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Steve",
      "offset": 19
    },
    {
      "val": "Astle",
      "offset": 31
    }
  ],
  "location": "GuiStepDefinition.enter_first_name_and(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "aa@gmail.com",
      "offset": 13
    }
  ],
  "location": "GuiStepDefinition.enteremail(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "laadf23",
      "offset": 16
    }
  ],
  "location": "GuiStepDefinition.enterpw(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "Mar",
      "offset": 14
    }
  ],
  "location": "GuiStepDefinition.slmonth(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "11",
      "offset": 12
    }
  ],
  "location": "GuiStepDefinition.slday(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "1992",
      "offset": 13
    }
  ],
  "location": "GuiStepDefinition.slyear(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "arguments": [
    {
      "val": "//input[@value\u003d\u00271\u0027]",
      "offset": 15
    }
  ],
  "location": "GuiStepDefinition.clickGender(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "GuiStepDefinition.clickcreatAcnt()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "GuiStepDefinition.printerror()"
});
formatter.result({
  "status": "skipped"
});
});