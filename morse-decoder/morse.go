package main

import "strings"

func decodeMorse(s string) string {

	result := ""
	words := strings.Split(s, "   ")
	for index, word := range words {
		for _, letter := range strings.Split(word, " ") {
			result += dictionnaire[letter]
		}

		if index < len(words)-1 {
			result += " "
		}
	}

	return result

}
