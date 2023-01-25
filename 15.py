for a in range(0, 300):
    success = False
    for x in range(1, 1000):
        result = (x / 5) <= ((x / 3) <= x + a >= 85)
        if result:
            print(a)
            success = True
            break
    if success:
        break