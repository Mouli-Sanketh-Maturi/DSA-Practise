func reverseBits(num uint32) uint32 {

	temp := uint32(0)

	for i := 0; i < 32; i++ {
		bit := num & 1
		temp = temp << 1
		temp = temp | bit
		num = num >> 1
	}

	return temp
}