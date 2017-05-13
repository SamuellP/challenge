from triangle import *

def runTests():

    if getMaxSum([[1]]) != 1:
        print("Error: The maximum total from top to bottom in [[1]] must be 1")
    if getMaxSum([[6],[3,5],[9,7,1],[4,6,8,4]]) != 26:
        print("Error: The maximum total from top to bottom in [[6],[3,5],[9,7,1],[4,6,8,4]] must be 26")
    if getMaxSum([[6],[12,5],[10,7,13],[4,60,8,4]]) != 88:
        print("Error: The maximum total from top to bottom in [[6],[12,5],[10,7,13],[4,60,8,4]] must be 88")
    else:
        print("Test run successfully")


if __name__ == '__main__':
    runTests()
