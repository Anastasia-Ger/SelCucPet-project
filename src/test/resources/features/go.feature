#In This file we can see two kinds of Cucumber tests: Scenarios and Scenario Outline


Feature: Language change
  Rule: User can change the language
    Scenario: When user hits the british flag, language changes to English
      Given I open Go website
      And  I accept privacy policy
      #check if language is Hungarian. If not switch to Hung, if yes, do nothing
      And language is set to 'hungarian'

      When I change language to 'english'
      Then language is changed to 'english'

    Scenario: When user hits the hungarian flag, language changes to Hungarian
      Given I open Go website
      And  I accept privacy policy
      And language is set to 'english'

      When I change language to 'hungarian'
      Then language is changed to 'hungarian'

#The following scenario demonstrates how to use Scenario Outline and tables of data
    Scenario Outline: Language can be changed to English and to Hungarian as well
      Given I open Go website
      And  I accept privacy policy
      And language is set to '<currentLanguage>'

      When I change language to '<newLanguage>'
      Then language is changed to '<expectedLanguage>'

    Examples:
    |currentLanguage  |newLanguage  |expectedLanguage  |
    | hungarian        |english     |english  |
    | english          |hungarian   |hungarian  |

#The following scenario demonstrates how to check the list of data
     Scenario: Change language multiple times
       Given I open Go website
       And  I accept privacy policy
       And language is set to 'hungarian'
       When I change language multiple times to the following:
        | english |
        | hungarian |
        | english |
        | hungarian|
       Then language is changed to 'hungarian'

       Scenario: Change languages with a table of multiple columns
         Given I open Go website
         And  I accept privacy policy
         And language is set to 'hungarian'
         When I change language multiple times with a DataTable:
           | language | dummy_column | code |
           | english | E             | eng  |
           | hungarian | H           | hun  |
           | english |               | eng  |
           | hungarian| H            | hun  |
         Then language is changed to 'hungarian'


