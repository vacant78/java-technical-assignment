# Notes

Please add here any notes, assumptions and design decisions that might help up understand your
though process.

## General discounts implementation thoughts:

Provide a transparent discount implementation that does not affect Basket implementation on per
discount basis. I changed implementation that was provided to aggregate items in the basket as they
are added. This choice allowed me to put discount implementations separately without affecting Item,
Product hierarchies. The product, item hierarchies were changed to allow basket items aggregations.
The item hierarchy was additionally changed to allow discount application.

Basket.discounts list - the idea is to be able to switch discounts without redefining products. Not
tested.

## Shortcomings

Separation of discounts and products - it is clearly not happening here, polluting to some extent
Product and tying up instances to a particular discount type. Ideally there would be a complementary
DiscountedProduct hierarchy that would seamlessly integrate with Items and only be picked up in
discounts implementations.

