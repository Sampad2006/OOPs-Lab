def coupon(day):

    mp={
        "Monday":"20%",
        "Tuesday":"30%",
        "Wednesday":"50%",
        "Thursday":"10%",
        "Friday":"5%",
        "Saturday": "25%",
        "Sunday": "30%"
    }

    day=day.strip().capitalize()

    if day in mp:
        print(mp[day]) 
    else:
        print("invalid day")

if __name__=="__main__":
    day=input()
    coupon(day)