def primegen(n):
    primes=[]
    num=2

    while(len(primes)<n):
        flag=True
        for i in range(2,(int(num**0.5)+1)): #root(num)+1
            if(num%i==0):
                flag=False
                break
        if(flag):
            primes.append(num)
        num+=1
    return primes

if __name__=="__main__":
    count=(int)(input())
    print(primegen(count))