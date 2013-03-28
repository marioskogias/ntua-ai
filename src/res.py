import os

for i in range(6):
	os.system("cp input"+str(i+1)+".txt input.txt")
	os.system("time java Main")
