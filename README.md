# simple-ga
This is a simple genetic algorithm that is used to find an array of integers. Each method is profusely commented so it should be relatively okay to figure out what each step does. 

The algorithm treates each individual as a single array of integers (its "chromosome") which contains a list of its "genes." The first generation is randomly generated and the process goes from there. Each generation is selected by simulating separate "survival tournaments" and "mating" the fittest individuals from each tournament to form a new individual. This individual's chromosome is then randomly mutated.
---
There is a client app included if you'd like to try for yourself. Playing around with the values in the GAConstants interface can change the result. Also, given that this was able to find an exact sequence of integers, I'm interested in how I can use apply this to strings. It should be the same thing given that strings can just be treated as character arrays. What kind of applications would that have?
---
At first I thought it could be used as a password cracker... but then I remembered that I was being stupid. No sane login portal would give you an indication of "how close" you were to the solution.... I shall think of other things.

This is my first try with this sort of thing. Credits to Holczer Balazs who discusses the various aspects of the genetic algorithm in his "Artificial Intelligence & Games in Java."
---
Sample graph generated when searching to match a solution of 20 elements:

![alt tag](http://i.imgur.com/io8GQYU.png)
