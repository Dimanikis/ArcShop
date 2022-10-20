<script>
import GreenBtn from '../GreenBtn.vue';
export default {
	methods: {
		close() {
			document
				.querySelector('.order-confirm')
				.classList.remove('order-confirm--active');
			document.body.classList.remove('nonscroll');
		},
	},
	components: { GreenBtn },
};
</script>

<template>
	<div class="order-confirm">
		<img
			class="order-confirm__img"
			src="@/assets/img/preloader.gif"
			alt="avocado"
		/>
		<span class="order-confirm__text"
			>Thank you for your purchase. Your package is on its way!</span
		>
		<GreenBtn class="order-confirm__btn" @click="close">Ok</GreenBtn>
	</div>
	<div class="order-confirm-overlay" @click="close"></div>
</template>

<style lang="scss">
.order-confirm-overlay {
	content: '';
	position: fixed;
	width: 100vw;
	height: 100vh;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	z-index: 19;
	transition: all 0.2s ease-in-out;
	background-color: rgba(0, 0, 0, 0.5);
	opacity: 0;
	visibility: hidden;
}

.order-confirm {
	position: fixed;
	top: 0;
	right: 0;
	left: 0;
	bottom: 0;
	z-index: 20;
	padding: 20px 60px;
	display: flex;
	flex-direction: column;
	align-items: center;
	max-width: 500px;
	max-height: 380px;
	border-radius: 15px;
	margin: auto;
	background: #f8f5f0;
	opacity: 0;
	visibility: hidden;

	&__img {
		width: 70%;
		margin-bottom: 10px;
	}

	&__text {
		font-weight: 400;
		font-size: 14px;
		line-height: 167%;
		color: $color-pale-black;
		margin-bottom: 30px;
		text-align: center;
	}

	&--active {
		opacity: 1;
		visibility: visible;
		& + .order-confirm-overlay {
			opacity: 1;
			visibility: visible;
		}
	}
}
</style>
