package main

import (
	"testing"
)

func TestDecodeUneChaineVide(t *testing.T) {
	test(t, decodeMorse(""), "", "decode une chaine vide")
}

func TestDecodeLaLettreA(t *testing.T) {
	test(t, decodeMorse(".-"), "A", "decode la lettre A")
}

func TestDecodeLaLettreB(t *testing.T) {
	test(t, decodeMorse("-..."), "B", "decode la lettre B")
}

func TestDecodeLaLettreC(t *testing.T) {
	test(t, decodeMorse("-.-."), "C", "decode la lettre C")
}

func TestDecodeLaLettreD(t *testing.T) {
	test(t, decodeMorse("-.."), "D", "decode la lettre D")
}

func TestDecodeLaLettreE(t *testing.T) {
	test(t, decodeMorse("."), "E", "decode la lettre E")
}

func TestDecodeLaLettreF(t *testing.T) {
	test(t, decodeMorse("..-."), "F", "decode la lettre F")
}

func TestDecodeLaLettreG(t *testing.T) {
	test(t, decodeMorse("--."), "G", "decode la lettre G")
}

func TestDecodeLaLettreH(t *testing.T) {
	test(t, decodeMorse("...."), "H", "decode la lettre H")
}

func TestDecodeLaLettreI(t *testing.T) {
	test(t, decodeMorse(".."), "I", "decode la lettre I")
}

func TestDecodeLaLettreJ(t *testing.T) {
	test(t, decodeMorse(".---"), "J", "decode la lettre J")
}

func TestDecodeLaLettreK(t *testing.T) {
	test(t, decodeMorse("-.-"), "K", "decode la lettre K")
}

func TestDecodeLaLettreL(t *testing.T) {
	test(t, decodeMorse(".-.."), "L", "decode la lettre L")
}

func TestDecodeLaLettreM(t *testing.T) {
	test(t, decodeMorse("--"), "M", "decode la lettre M")
}

func TestDecodeLaLettreN(t *testing.T) {
	test(t, decodeMorse("-."), "N", "decode la lettre N")
}

func TestDecodeLaLettreO(t *testing.T) {
	test(t, decodeMorse("---"), "O", "decode la lettre O")
}

func TestDecodeLaLettreP(t *testing.T) {
	test(t, decodeMorse(".--."), "P", "decode la lettre P")
}

func TestDecodeLaLettreQ(t *testing.T) {
	test(t, decodeMorse("--.-"), "Q", "decode la lettre Q")
}

func TestDecodeLaLettreR(t *testing.T) {
	test(t, decodeMorse(".-."), "R", "decode la lettre R")
}

func TestDecodeLaLettreS(t *testing.T) {
	test(t, decodeMorse("..."), "S", "decode la lettre S")
}

func TestDecodeLaLettreT(t *testing.T) {
	test(t, decodeMorse("-"), "T", "decode la lettre T")
}

func TestDecodeLaLettreU(t *testing.T) {
	test(t, decodeMorse("..-"), "U", "decode la lettre U")
}

func TestDecodeLaLettreV(t *testing.T) {
	test(t, decodeMorse("...-"), "V", "decode la lettre V")
}

func TestDecodeLaLettreW(t *testing.T) {
	test(t, decodeMorse(".--"), "W", "decode la lettre W")
}

func TestDecodeLaLettreX(t *testing.T) {
	test(t, decodeMorse("-..-"), "X", "decode la lettre X")
}

func TestDecodeLaLettreY(t *testing.T) {
	test(t, decodeMorse("-.--"), "Y", "decode la lettre Y")
}

func TestDecodeLaLettreZ(t *testing.T) {
	test(t, decodeMorse("--.."), "Z", "decode la lettre Z")
}

func TestDecodeUnMotDe2Lettres(t *testing.T) {
	test(t, decodeMorse(".... .."), "HI", "decode le mot HI")
}

func TestDecodeUnMotDe3Lettres(t *testing.T) {
	test(t, decodeMorse(".... . -.--"), "HEY", "decode le mot HEY")
}
func TestDecode2Mots(t *testing.T) {
	test(t, decodeMorse(".... . .-.. .-.. ---     .-- --- .-. .-.. -.."), "HELLO WORLD", "decode le message HELLO WORLD")
}
