# Functional Tic Tac Toe Workshop
## Pre-work
### The Exercise
Implement the user stories in Tic Tac Toe through “Location already taken” using Java 8. We’ll have the extra constraint of limiting our methods to a cyclomatic complexity of 1. 

That means that you won’t be using any loops, ifs, or other control structure (like switch). Another way to think of this is that there will only be only one flow through each method. Make sure that you TDD diligently, it will help. Work solo, in pairs, or as a group. Whatever makes the most sense for you.
#### Tools You Could Use
* Filter instead of the foreach-loop/if idiom
* Map instead of foreach-loop
* Recursion for loops that filter and map don’t help with
* Map<>, enums, and polymorphism for dispatching different behaviors
* Other conditionals (especially null checks) can be replaced with Optional<>

#### Resources
* [Oracle Filter/Map Tutorial](https://docs.oracle.com/javase/tutorial/collections/streams/reduction.html)
* [Oracle Optional Tutorial](http://www.oracle.com/technetwork/articles/java/java8-optional-2175753.html)

#### Advice
I expect this to be challenging for most ACs (and programmers in general) because it forbids some of our most commonly used tools and replaces them with tools that we use less frequently (or not at all). 

This exercise is easier if you work from the top (usually the UI) and work your way down. Lean heavily on [Tell, Don’t Ask](https://pragprog.com/articles/tell-dont-ask) and [Keep It DRY, Shy, and Tell the Other Guy](https://media.pragprog.com/articles/may_04_oo1.pdf). If you find yourself using accessors, you’re going to have a bad time with this exercise.

## Workshop
### Review
* Set Context: Review the Pre-work problem and Workshop Agenda (10 minutes)
* Share Experience: Group discussion about the Pre-work (20 minutes)
* Share Code: We’ll project and review the pre-work from three attendees (30 minutes)

### Code
* Set Context: Review the AI part of the exercise (10 minutes)
* Do Exercise: Repeat four times
** Code: Work on stories in order (40 minutes)
** Share: Project progress from one solution and discuss (~10 minutes)
** Break: Get away from your computer and move around (10 minutes)

### Closing
* Review one solution in detail (20 minutes)
* Discuss what we learned (30 minutes)
