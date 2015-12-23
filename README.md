# simple-ga
This is a simple genetic algorithm that is used to find an array of integers. Each method is profusely commented so it should be relatively okay to figure out what each step does. 

The algorithm treates each individual as a single array of integers (its "chromosome") which contains a list of its "genes." The first generation is randomly generated and the process goes from there. Each generation is selected by simulating separate "survival tournaments" and "mating" the fittest individuals from each tournament to form a new individual. This individual's chromosome is then randomly mutated.
___
There is a client app included if you'd like to try for yourself. Playing around with the values in the GAConstants interface can change the result. Also, given that this was able to find an exact sequence of integers, I'm interested in how I can use apply this to strings. It should be the same thing given that strings can just be treated as character arrays. What kind of applications would that have?
___
After playing around with it, I have realized a few important things. To those who have had experience with this, my findings may seem common sense but I'm just going to put them here because I am the supreme leader in this repository. Originally, it was too difficult for the program to match a 50 integer solution with numbers randing from 10 to 99. At first I thought this was because of the number 50, but realized instead it was because a mutation rate of 0.15 is much too high. A high mutation rate early-on allows the algorithm to serach a wide range of possibilities but disallows convergence to an optimal solution in later generations. I actually ended up keeping my computer running all night to no avail. I've changed the mutation rate to a lower 0.025 now.

A high population also seems to decrease the average number of generations it takes to reach a solution. Given that the most expensive parts of the algorithm have a time complexity of O(n) where n is the number of elements in each chromosome, the runtime should increase linearly with an increase in population (iterates over population every generation).

Increasing the range of possible values from (0, 9) to (0, 99) also substantially increased the average number of generations required to find a solution. This is obviously because of how many more options each gene has, so the original population should have a higher variation in fitness. However, I realized that this does not pose as much of a problem when the mutation rate isn't insanely high (0.15... what was I thinking?). Also, it is important to note that having a lower mutation rate will cause the algorithm to get "stuck" for many generations at a time. These can be observed by the segments of the graph with gradient 0.

If you want to get a good feel for how this sort of thing works, I suggest also playing around with the various constants. I have added a couple of sample solution sequences of varying sizes and variance in values.
___
This is my first try with this sort of thing. Credits to Holczer Balazs who discusses the various aspects of the genetic algorithm in his "Artificial Intelligence & Games in Java."
___
Sample graph generated when searching to match a solution of 20 elements:

![alt tag](http://i.imgur.com/io8GQYU.png)
