def partition(x, first, last):
	print("\nCalling partition with", x, first, last, " partition chosen is", x[first])
	pivot = x[first]
	left = first
	right = last
	while left < right:
		while pivot < x[right]:
			right -= 1
		
		
		while left < right and x[left] <= pivot:
			left += 1

		if left < right:
			print("Swap pos", left, right)
			temp = x[left]
			x[left] = x[right]
			x[right] = temp

	print("Move partition into place.  Swap first element=", first, "with with rightpos=", right)
	pos = right
	x[first] = x[pos]
	x[pos] = pivot
	print("After partition, x is ", x)
	return pos

def quicksort(x, first, last):
	print("call to quicksort: ", first, last)
	if first < last:
		pos = partition(x, first, last)
		quicksort(x, first, pos-1)
		quicksort(x, pos+1, last)

def main():
	x=[40, 10, 30, 12, 50, 90, 20, 60, 57, 34, 55]
	#quicksort(x, 0, 10)
	#print("final x", x)
	#print()

	x=[5, 2, 9, 10, 7, 3, 4, 6, 1]
	quicksort(x, 0, 8)
	print("final x", x)
	print()

	x=[54, 26, 93, 17, 77, 31, 44, 55, 20]
	#quicksort(x, 0, 8)
	#print("final x", x)
	#print()

	x=[50, 90, 80, 70, 30, 20, 10]
	#quicksort(x, 0, 6)
	#print("final x", x)
	#print()

	x=[48, 25, 70, 95, 9, 16, 61, 39, 56,  18, 83]
	#quicksort(x,0,10)
	#print("final array", x)
	#print()

	x=[6,	10,	3,	2,	12, 14,	11,	5]
	#quicksort(x,0,7)
	#print("final array", x)
	#print()

	x=[7,7,7,7,7,7,7]
	#quicksort(x,0,6)
	#print("final array", x)
	#print()

	x=[9,8,7,6,5,4,3,2,1]
	#quicksort(x,0,len(x)-1)
	#print("final array", x)
	#print()

	x=[3,4,5,2,6,1]
	#quicksort(x,0,len(x)-1)
	#print("final array", x)
	#print()

	x=[20,21,22,23,1,2,3]
	#quicksort(x,0,len(x)-1)
	#print("final array", x)
	#print()

	x=[44,75,23,43,55,12,64,77,33]
	quicksort(x,0,len(x)-1)
	print("final array", x)
	print()
main()
