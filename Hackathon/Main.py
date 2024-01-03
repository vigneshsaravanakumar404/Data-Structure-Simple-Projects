import math

def lcm(a, b):
    return abs(a * b) // math.gcd(a, b)

def smallest_divisible():
    result = 1
    for i in range(1, 16):
        result = lcm(result, i)
    return result

smallest_integer = smallest_divisible()
print(smallest_integer)
