# This project is a cloned version of David Gageot's legacy code presentation

## Your tasks

Your tasks are to :

* Unfortunately we have no specification for the business rules and will have to make our app 
safer refactoring it. So refactore the LegacyInn class anyway you want, add any class you want ...
If you can make the method updateQuality a bit more than 20 lines it would be nice.
## New feature

We have recently signed a supplier of conjured items. This requires an update to our system:

* “Conjured” items degrade in Quality twice as fast as normal items

Feel free to make any changes to the UpdateQuality method and add any new code as long as everything still works correctly. However, do not alter the Item class or Items property as those belong to the goblin in the corner who will insta-rage and one-shot you as he doesn’t believe in shared code ownership (you can make the UpdateQuality method and Items property static if you like, we’ll cover for you).

# Misc Links

* Original Kata Code : https://github.com/NotMyself/GildedRose


IF you don't have maven installed on your computer then you can use a maven wrapper which is available. 
So no previous maven installation is required.
Prerequisites : MAVEN_HOME variable set.
We can run for the Unix system:
	
./mvnw clean install

And the following command for windoze :
	
./mvnw.cmd clean install