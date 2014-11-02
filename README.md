Deck-o-Cards
=========

## Description

Following the principle of least surprise, this project represents a simple poker-style playing cards which has made reasonable decisions regarding implementation, in the possibility that it would become a foundational part of an application in the future.

This implementation will randomly traverse and reorder all cards in deck using an in memory technique over a single pass of the deck. A card will be randomly selected and inserted at random at the end of the deck.

## Installation
Then you can download this repository with the following command:

    git clone https://github.com/amadib/deck-o-cards.git

## MainClass
The main class of this project is `Dealer` and can be found in Dealer.java.

## Dependencies
This project has dependencies on log4j and can be built and ran using [Maven](http://maven.apache.org/download.cgi). 

The project may be built and executed with maven by running the following command:

    mvn install exec:java -Dmaven.test.skip=true

Importing the project as an *Existing Maven Project* within eclipse with the [M2eclipse](https://www.eclipse.org/m2e/) plugin installed and running the following goal:

    install exec:java -Dmaven.test.skip=true
    
*Note: log4j logging has been turned off by default.*

###Version

1.0

### Deprecated
Parts of the **com.appian.cards.Card** class have been deprecated in favor of a *"better"* solution.
