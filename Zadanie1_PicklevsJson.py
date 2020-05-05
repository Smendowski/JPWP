import lorem
import re
import random
import time
import json
import _pickle as pickle

long_sentence = ""
for x in range (50):
	long_sentence += lorem.sentence()

word_list = re.split('\s+', long_sentence)

flat_list_pickle = [[] for x in range(100)]
for i in range (100):
	for j in range(100):
		flat_list_pickle[i].append(random.choice(word_list))

flat_list_json = flat_list_pickle.copy()

tic = time.perf_counter()
jsonOut = json.dumps(flat_list_json)
jsonIN = json.loads(jsonOut)
toc = time.perf_counter()
print("JSON TIME: " ,toc - tic)

tic = time.perf_counter()
pickleOut = pickle.dumps(flat_list_pickle)
pickleIn = pickle.loads(pickleOut) 
toc = time.perf_counter()
print("PICKLE TIME: " ,toc - tic)
