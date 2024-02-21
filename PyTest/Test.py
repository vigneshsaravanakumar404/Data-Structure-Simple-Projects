import pytest

# Functions to Test
def add(a, b):
    return a + b

def subtract(a, b):
    return a - b

def multiply(a, b):
    return a * b

def divide(a, b):
    return a / b

def is_sorted(numbers):
    return numbers == sorted(numbers)

# Test Methods
def test_add():
    assert add(2, 3) == 5
    assert add(1, -1) == 0

def test_subtract():
    assert subtract(5, 2) == 3
    assert subtract(2, 5) == -3

def test_multiply():
    assert multiply(2, 3) == 6
    assert multiply(2, -3) == -6

@pytest.mark.parametrize("test_input,expected", [
    ([1, 2, 3, 4, 5], True),  # Already sorted list
    ([5, 4, 3, 2, 1], False), # Descending order list
    ([1], True),              # Single element list
    ([], True),               # Empty list
    ([1, 2, 3, 5, 4], False)  # Unsorted list
])
def test_is_sorted(test_input, expected):
    assert is_sorted(test_input) == expected

def test_divide():
    assert divide(6, 3) == 2
    assert divide(3, 6) == 0.5
    assert divide(0, 0) == None


