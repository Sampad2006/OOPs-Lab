import os

def findfiles(directory):
    """
    Recursively descends the directory tree for the specified 
    directory and generates paths of all files.
    """
    # Root is the folder being looked at, 
    # Dirs is a list of subfolders, 
    # Files is a list of file names in the current root.
    for root, dirs, files in os.walk(directory):
        for filename in files:
            # Join the folder path and the filename to get the full path
            file_path = os.path.join(root, filename)
            yield file_path

# test
project_path = "." #root

print(f"Generating paths for: {os.path.abspath(project_path)}\n")

for path in findfiles(project_path):
    print(path)