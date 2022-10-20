<script>
import SectionTitle from '../SectionTitle.vue';
import GreenBtn from '../GreenBtn.vue';
export default {
	data() {
		return {
			email: null,
			isPressedBtn: false,
			successfulMsg: false,
		};
	},
	computed: {
		emailIsValid() {
			return /(.+)@(.+){2,}\.(.+){2,}/.test(this.email);
		},
	},
	methods: {
		submitForm() {
			if (this.emailIsValid) {
				this.successfulMsg = true;
				this.isPressedBtn = false;
				this.email = null;
			} else {
				this.isPressedBtn = true;
				this.successfulMsg = false;
			}
		},
	},
	components: { SectionTitle, GreenBtn },
};
</script>

<template>
	<section class="subscribe">
		<div
			class="left-img imgg"
			data-aos="fade-right"
			data-aos-once="true"
			data-aos-delay="500"
		>
			<img src="@/assets/img/greens1.png" alt="greens" />
		</div>
		<div class="container subscribe__container">
			<SectionTitle class="subscribe__title">
				Subscribe Newsletter</SectionTitle
			>
			<form class="subscribe__form" @submit.prevent="submitForm">
				<div class="field subscribe__email">
					<input
						class="field__input"
						type="text"
						name="email"
						id="email"
						placeholder=""
						v-model="email"
					/>
					<label for="email" class="field__label">Your email:</label>
					<p
						class="error-msg error-msg--bigger"
						v-if="!emailIsValid && isPressedBtn"
					>
						Invalid email
					</p>
					<p class="successful-msg" v-if="successfulMsg">
						Thank you for your subscribe ❤
					</p>
				</div>
				<GreenBtn class="subscribe__btn">subscribe</GreenBtn>
			</form>
		</div>
		<div
			class="right-img img"
			data-aos="fade-left"
			data-aos-once="true"
			data-aos-delay="500"
		>
			<img src="@/assets/img/greens2.png" alt="greens" />
		</div>
	</section>
</template>

<style lang="scss">
.subscribe {
	overflow: hidden;
	position: relative;
	display: flex;
	justify-content: space-between;
	padding-bottom: 60px;
	background-color: $color-light-yellow;

	&__container {
		@include py(60px);
		position: absolute;
		top: 0;
		left: 50%;
		transform: translateX(-50%);
	}

	&__title {
		margin-bottom: 20px;
		text-align: center;
	}

	&__form {
		display: flex;
		flex-direction: column;
		align-items: center;
	}

	&__email {
		@include max-res-width(600px);

		margin-bottom: 20px;
	}

	&__btn {
		max-width: 150px;
		@include flex-center;
	}
}

.field {
	position: relative;
	height: 48px;
	border-radius: 5px;
	border: 1px solid $color-light-green;

	&__input {
		font-size: 14px;
		line-height: 1.2;
		@include wh(100%);
		@include px(30px);
		padding-top: 10px;
	}

	&__label {
		position: absolute;
		top: 50%;
		transform: translateY(-50%);
		font-size: 14px;
		line-height: 1;
		color: rgba($color-pale-black, 0.8);
		left: 20px;
		transition: all 0.1s;
		cursor: text;
	}

	&__input:focus ~ &__label,
	&__input:not(:placeholder-shown) ~ &__label {
		font-size: 10px;
		top: 5px;
		letter-spacing: 0.04rem;
		transform: none;
	}
}

@media screen and (min-width: $tablet) {
	.subscribe {
		&__title {
			margin-bottom: 30px;
		}

		&__form {
			display: flex;
			flex-direction: row;
			justify-content: center;
		}

		&__email {
			font-size: 16px;
			margin-bottom: 0;
			margin-right: 20px;
		}

		&__btn {
			height: 48px;
			max-width: 150px;
			@include flex-center;
		}
	}
}
</style>
