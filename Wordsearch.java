package wordsearch;

import java.util.Random;

public class Wordsearch {

	private String[] keyword;

	private char[][] matix;
	private int l, w;
	private Random random_number;

	// phase 1 = make a matrix

	public Wordsearch(int l, int w) {

		this.l = l;
		this.w = w;
		this.matix = new char[l][w];

		for (int i = 0; i < l; i++) {

			for (int j = 0; j < w; j++) {

				this.matix[i][j] = '0';
			}
		}

		this.random_number = new Random();

		this.keyword = new String[] { "canada", "york" };

	}

	void initMatrix() {

		for (int k = 0; k < keyword.length; k++) {

			String result = keyword[k];

			int length = 0;
			int weigth = 0;

			// make sure the first letter of a word is inserted in empty pivot
			int locker = 1;
			while (locker == 1)

			{
				length = random_number.nextInt(10);
				weigth = random_number.nextInt(10);
				if (this.matix[length][weigth] == '0') {

					locker = 0;

				}

			}

			this.matix[length][weigth] = (char) result.charAt(0);

			int inside = 0;

			// insert keyword randomly inside the matrix
			while (inside == 0) {

				int randomized_choice = random_number.nextInt(4);

				// direction 1 - horiz - right
				if (((w - 1) - weigth >= (result.length() - 1)) && randomized_choice == 0) {

					int keyword_index = 0;

					int stopPoint = weigth + (result.length() - 1);

					int lock = 0;
					for (int a = weigth + 1; a <= stopPoint; a++) {

						if (this.matix[length][a] != '0') {

							lock = 1;
						}
					}

					if (lock == 0) {

						for (int h = weigth; h <= stopPoint; h++) {

							this.matix[length][h] = (char) result.charAt(keyword_index);
							keyword_index++;
							inside = 1;
						}

					}
				}

				// direction 2 - horiz - left
				if ((weigth >= (result.length() - 1)) && randomized_choice == 1) {

					int keyword_index = 0;
					int stopPoint = Math.abs(weigth - (result.length() - 1));

					int lock = 0;
					for (int a = weigth - 1; a >= stopPoint; a--) {

						if (this.matix[length][a] != '0') {

							lock = 1;
						}
					}

					if (lock == 0) {

						for (int h = weigth; h >= stopPoint; h--) {
							this.matix[length][h] = result.charAt(keyword_index);
							keyword_index++;
							inside = 1;
						}

					}
				}

				// direction 3 - vert - up

				if ((length >= (result.length() - 1)) && randomized_choice == 2) {

					int keyword_index = 0;
					int stopPoint = Math.abs(length - (result.length() - 1));

					int lock = 0;
					for (int a = length - 1; a >= stopPoint; a--) {

						if (this.matix[a][weigth] != '0') {

							lock = 1;
						}
					}

					if (lock == 0) {

						for (int h = length; h >= stopPoint; h--) {
							this.matix[h][weigth] = result.charAt(keyword_index);
							keyword_index++;
							inside = 1;
						}

					}

				}

				// direction 4 - vert - down
				if (((l - 1) - length >= (result.length() - 1)) && randomized_choice == 3) {

					int keyword_index = 0;

					int stopPoint = length + (result.length() - 1);

					int lock = 0;
					for (int a = length + 1; a <= stopPoint; a++) {

						if (this.matix[a][weigth] != '0') {

							lock = 1;
						}

					}

					if (lock == 0) {

						for (int h = length; h <= stopPoint; h++) {

							this.matix[h][weigth] = (char) result.charAt(keyword_index);
							keyword_index++;
							inside = 1;
						}

					}
				}

				// direction 5 - diagnal up right

			}

		}

		for (int i = 0; i < l; i++) {

			for (int j = 0; j < w; j++) {

				if (this.matix[i][j] != '0') {

				}
				if (this.matix[i][j] == '0') {
					char c = (char) (random_number.nextInt(26) + 'a');
					this.matix[i][j] = c;
				}
			}
		}

	}

	void printMatrix() {

		for (int i = 0; i < l; i++) {

			for (int j = 0; j < w; j++) {

				System.out.print(matix[i][j] + "  ");
			}
			System.out.println("\n      ");
		}
	}

	// phase2 insert the key word inside the matrix

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Wordsearch a = new Wordsearch(10, 10);
		a.initMatrix();
		a.printMatrix();

	}

}
