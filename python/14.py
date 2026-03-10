import heapq

class PriorityQueue:
    def __init__(self):
        self._queue = []
        self._index = 0

    def push(self, item, priority):
        """
        Pushes an item with a priority. 
        Higher number = Higher priority.
        """
        # We use -priority because heapq is a min-heap. 
        # Making the priority negative allows us to simulate a max-heap.
        # self._index acts as a tie-breaker if two items have the same priority.
        heapq.heappush(self._queue, (-priority, self._index, item))
        self._index += 1

    def pop(self):
        """Returns the item with the highest priority."""
        if not self._queue:
            return None
        # Returns the item (the last element in the stored tuple)
        return heapq.heappop(self._queue)[-1]

def main():
    pq = PriorityQueue()
    print("--- Priority Queue Manager ---")
    print("Commands: 'add <item> <priority>', 'pop', 'exit'")

    while True:
        user_input = input("\n> ").strip().split()
        
        if not user_input:
            continue
            
        command = user_input[0].lower()

        if command == "exit":
            print("Shutting down...")
            break

        elif command == "add":
            try:
                # Expecting: add [task_name] [priority_integer]
                # Handles multi-word task names
                item_name = " ".join(user_input[1:-1])
                priority_val = int(user_input[-1])
                
                pq.push(item_name, priority_val)
                print(f"Added '{item_name}' with priority {priority_val}")
            except (ValueError, IndexError):
                print("Error: Use format 'add <name> <priority_integer>'")

        elif command == "pop":
            result = pq.pop()
            if result:
                print(f"Popped Highest Priority Item: {result}")
            else:
                print("Queue is empty.")
        
        else:
            print("Unknown command.")

if __name__ == "__main__":
    main()