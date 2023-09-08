package main

import (
	"fmt"
	"testing"
)

func test(t *testing.T, actual any, expected any, message string) {
	if actual != expected {
		fmt.Printf("\t\nactual: %#v", actual)
		fmt.Printf("\t\nexpected: %#v\n", expected)
		t.Errorf("%s", message)
	}

}
