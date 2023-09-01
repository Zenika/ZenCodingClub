package main

import (
	"strings"
	"testing"
)

func decodeMorse(s string) string {

	dictionnaire := map[string]string{
		".-":   "A",
		"-...": "B",
		"-.-.": "C",
		"-..":  "D",
		".":    "E",
		"..-.": "F",
		"--.":  "G",
		"....": "H",
		"..":   "I",
		".---": "J",
		"-.-":  "K",
		".-..": "L",
		"--":   "M",
		"-.":   "N",
		"---":  "O",
		".--.": "P",
		"--.-": "Q",
		".-.":  "R",
		"...":  "S",
		"-":    "T",
		"..-":  "U",
		"...-": "V",
		".--":  "W",
		"-..-": "X",
		"-.--": "Y",
		"--..": "Z",
	}

	if strings.Contains(s, " ") {
		parts := strings.Split(s, " ")
		return dictionnaire[parts[0]] + dictionnaire[parts[1]]
	}

	return dictionnaire[s]

}

func TestDecodeUneChaineVide(t *testing.T) {

	if decodeMorse("") != "" {

		t.Fatalf("failed")
	}
}

func TestDecodeLaLettreA(t *testing.T) {

	if decodeMorse(".-") != "A" {

		t.Fatalf("failed")
	}
}

func TestDecodeLaLettreB(t *testing.T) {

	if decodeMorse("-...") != "B" {

		t.Fatalf("failed")
	}
}

func TestDecodeLaLettreC(t *testing.T) {

	if decodeMorse("-.-.") != "C" {

		t.Fatalf("failed")
	}
}

func TestDecodeLaLettreD(t *testing.T) {

	if decodeMorse("-..") != "D" {

		t.Fatalf("failed")
	}
}

func TestDecodeLaLettreE(t *testing.T) {

	if decodeMorse(".") != "E" {

		t.Fatalf("failed")
	}
}

func TestDecodeLaLettreF(t *testing.T) {

	if decodeMorse("..-.") != "F" {

		t.Fatalf("failed")
	}
}

func TestDecodeLaLettreG(t *testing.T) {

	if decodeMorse("--.") != "G" {

		t.Fatalf("failed")
	}
}

func TestDecodeLaLettreH(t *testing.T) {

	if decodeMorse("....") != "H" {

		t.Fatalf("failed")
	}
}

func TestDecodeLaLettreI(t *testing.T) {

	if decodeMorse("..") != "I" {

		t.Fatalf("failed")
	}
}

func TestDecodeLaLettreJ(t *testing.T) {

	if decodeMorse(".---") != "J" {

		t.Fatalf("failed")
	}
}

func TestDecodeLaLettreK(t *testing.T) {

	if decodeMorse("-.-") != "K" {

		t.Fatalf("failed")
	}
}

func TestDecodeLaLettreL(t *testing.T) {

	if decodeMorse(".-..") != "L" {

		t.Fatalf("failed")
	}
}

func TestDecodeLaLettreM(t *testing.T) {

	if decodeMorse("--") != "M" {

		t.Fatalf("failed")
	}
}

func TestDecodeLaLettreN(t *testing.T) {

	if decodeMorse("-.") != "N" {

		t.Fatalf("failed")
	}
}

func TestDecodeLaLettreO(t *testing.T) {

	if decodeMorse("---") != "O" {

		t.Fatalf("failed")
	}
}

func TestDecodeLaLettreP(t *testing.T) {

	if decodeMorse(".--.") != "P" {

		t.Fatalf("failed")
	}
}

func TestDecodeLaLettreQ(t *testing.T) {

	if decodeMorse("--.-") != "Q" {

		t.Fatalf("failed")
	}
}

func TestDecodeLaLettreR(t *testing.T) {

	if decodeMorse(".-.") != "R" {

		t.Fatalf("failed")
	}
}

func TestDecodeLaLettreS(t *testing.T) {

	if decodeMorse("...") != "S" {

		t.Fatalf("failed")
	}
}

func TestDecodeLaLettreT(t *testing.T) {

	if decodeMorse("-") != "T" {

		t.Fatalf("failed")
	}
}

func TestDecodeLaLettreU(t *testing.T) {

	if decodeMorse("..-") != "U" {

		t.Fatalf("failed")
	}
}

func TestDecodeLaLettreV(t *testing.T) {

	if decodeMorse("...-") != "V" {

		t.Fatalf("failed")
	}
}

func TestDecodeLaLettreW(t *testing.T) {

	if decodeMorse(".--") != "W" {

		t.Fatalf("failed")
	}
}

func TestDecodeLaLettreX(t *testing.T) {

	if decodeMorse("-..-") != "X" {

		t.Fatalf("failed")
	}
}

func TestDecodeLaLettreY(t *testing.T) {

	if decodeMorse("-.--") != "Y" {

		t.Fatalf("failed")
	}
}

func TestDecodeLaLettreZ(t *testing.T) {

	if decodeMorse("--..") != "Z" {

		t.Fatalf("failed")
	}
}

func TestDecodeUnMotDe2Lettres(t *testing.T) {

	if decodeMorse(".... ..") != "HI" {

		t.Fatalf("failed")
	}
}

func TestDecodeUnMotDe3Lettres(t *testing.T) {

	if decodeMorse(".... . -.--") != "HEY" {

		t.Fatalf("failed")
	}
}
