//Avaliações Iniciais

const ratings = {
	filmeum: 5,
	filmedois: 5,
	filmetres: 5,
	filmequatro: 5,
	filmecinco: 5
}

//Avaliação de total (Quantidade de estrelas)
const starsTotal = 5;

//Usando DOM e chamar o getRatings
document.addEventListener('DOMContentLoaded', getRatings);

//Form elements
const filmSelect = document.getElementById('select-film');
const ratingControl = document.getElementById('rating-control');

let film;

//Film select change
filmSelect.addEventListener('change', (e) => {
	film = e.target.value;
	ratingControl.disable = false;
	ratingControl.value = ratings[film];
});

ratingControl.addEventListener('blur', (e) => {
	const rating = e.target.value;

	if(rating > 5) {
		alert('Please rate film');
		return;
	}

	ratings[film] = ratings;

	getRatings();
});

//GET avaliações
function getRatings(){
	for(let rating  in ratings){
		const starPercentage = (ratings[rating] / starsTotal) * 100;
	
		const starsPercentageRounded = `${Math.round(starPercentage / 10) * 10}%`;		
		
		document.querySelector(`.${rating}.star-inner`).style.width = starsPercentageRounded;

		document.querySelector(`.${rating}.number-rating`).innerHTML = ratings[rating];
	}
}