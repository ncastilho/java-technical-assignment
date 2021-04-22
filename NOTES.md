# Notes

Please add here any notes, assumptions and design decisions that might help up understand your though process.

I've started by focusing on the DiscountCalculator component, with an intention of keeping 
the discount logic separate.

I associated the __Discount__ strategy with each __Item__ instead of on the __Product__; 
 - first, because there isn't a common ancestor for __Product__ and __WeightedProduct__
 - second, because having the amount (units / kg) is needed for the discount calculation.

I ran out of time (and indeed went over it). 

There's one discount yet to implement, and certainly some cleanup in the tests would be in order.

I kind of regret of how the __DiscountCalculatorTest__ ended up. I think those test cases probably would be
best suited on the __BasketTest__ instead :/