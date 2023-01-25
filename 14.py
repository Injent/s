for sys in range(2, 17):
    for first in range(0, sys):
        for second in range(0, sys):
            for third in range(0, sys):
                start = int(f"{first}{second}{third}", sys)
                nums = [first, second, third]

                for index in range(0, 3):
                    if nums[index] > 0:
                        nums[index] = nums[index] - 1

                end = int(f"{nums[0]}{nums[1]}{nums[2]}", sys)

                result = start - end

                if result == 26:
                    print(sys)
                    break
