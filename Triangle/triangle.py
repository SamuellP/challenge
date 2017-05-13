
def maxSum(triangle, i, j):

    if i == len(triangle)-1:
        return triangle[i][j]

    left = maxSum(triangle, i+1, j)
    right = maxSum(triangle, i+1, j+1)

    if (triangle[i][j] + left) > (triangle[i][j] + right):
        return (triangle[i][j] + left)
    else:
        return (triangle[i][j] + right)




def getMaxSum(triangle):
    return maxSum(triangle,0,0)
