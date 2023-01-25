def f(n):
    bin_str = bin(n)

    for i in range(0, 2):
        if n % 2 == 0:  # если четное, то справа записывается 11
            bin_str = bin_str + "11"
        else:  # если четное, то справа записывается 0
            bin_str = bin_str + "0"

    return int(bin_str, 2)  # конвертируется в десятичную запись из двоичной


for i in range(0, 100):
    result = f(i) # используется 1-й раз
    if result > 240: # если больше 240 то ответ
        print(i)
        break