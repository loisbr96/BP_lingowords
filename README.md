LoLingo words application
======

[![codecov](https://codecov.io/gh/loisbr96/BP_lingowords/branch/master/graph/badge.svg?token=RKCW4UUJVQ)](https://codecov.io/gh/loisbr96/BP_lingowords)

Commands
------
|What  | Command    | Explanation                               |
| -----|------------| ------------------------------------------|
| Help | help       | Get all the commands and their information|
| Exit | exit       | Shutdown the application                  |
| Clear | clear     | Clears the screen, resetting the prompt   |
| Read | read        | read the given file                      |

parameters
--

|What  | Command    | Explanation                               |
| -----|------------| ------------------------------------------|
| filename | --file | to say witch file has to be uploaded|

#Beoordeling
## Build tools en pipeline
De applicatie gebruikt de **build tool** Maven. Daarnaast is er op Github Action een workflow aangemaakt die zorgt dat er een **pipeline** draait als er naar master wordt gepusht. **master** is altijd deploybaar.

## Mate van functionaliteit
De shell applicatie kan door middel van een file de woorden uitlezen, controleren en versturen naar de API van LoLingo-game.

## Testorganisatie
Er zijn unit testen gedaan voor de source en service. Er is een externe integratie test geschreven voor target door middel van wiremock. Interne integratie testen lukte niet door de shell component van Springboot. Veel pogingen gedaan, uiteindelijk 2 pogingen uitgecommend toegevoegd. Hierdoor is helaas de coverage ook laag, omdat shell methods niet getest konden worden.  

## Mate van clean test
Er is gebruik van mocking om de unit testen onafhankelijk te testen. Ook mocking gebruikt voor target. Daarnaast een txt-bestand met woorden om te testen bijgevoegd.

## Coverage en mutation testen
CodeCov controleert via de **build** standaard de code kwaliteit. Via Codecov is de **badge** beschikbaar in deze README. De coverage is lager omdat de WireMock en EndToEnd niet mee worden gerekend. Het was helaas niet haalbaar om de shell commands te testen. De Springboottest blijft hangen op de Testclasse en geeft geen duidelijke error. Ondanks meerdere pogingen, is dit helaas niet gelukt. Ik heb de tests wel toegevoegd als bewijs dat er wel over na is gedacht. In de LiLingo-game is de Springboottest wel gelukt en is de coverage hoog.

## Mate van structuur
De structuur is zo opgebouwd dat de logica los van elkaar is. Ook bevat Command geen logica en wordt het alleen gebruikt als door-geef-luik. Er zijn interfaces toegevoegd zodat we naast een file ook andere bronnen kunnen toevoegen of een andere target kunnen gebruiken. 
Er is gebruik gemaakt van dependency injection door het Springboot Framework.

## Mate van netheid
Duidelijke benaming, loggers toegepast en goeie exceptie afhandeling. 

## Static analysis tools
PMD en Jdepend zijn toegepast in het project. Via Maven verify wordt er gecontroleerd/geanalyseerd en een rapportage gegenereerd.

## Packaging
De code wordt aangeboden via een release. 

## Bronvermelding
Bronvermelding is aangegeven in de pom.xml. Er is geen code een op een overgenomen, meer gewerkt aan de hand van tutorials/voorbeelden.
