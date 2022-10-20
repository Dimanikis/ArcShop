<script>
import SectionTitle from '../SectionTitle.vue';
import SectionDescription from '../SectionDescription.vue';
import GreenBtn from '../GreenBtn.vue';
export default {
	data() {
		return {
			name: null,
			email: null,
			phone: null,
			msg: null,
			isPressedBtn: false,
			successfulMsg: false,
		};
	},
	computed: {
		nameIsValid() {
			return !!this.name;
		},
		emailIsValid() {
			return /(.+)@(.+){2,}\.(.+){2,}/.test(this.email);
		},
		phoneIsValid() {
			return /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/.test(
				this.phone
			);
		},
		msgIsValid() {
			return /\w+ \w+/.test(this.msg);
		},
		formIsValid() {
			return (
				this.nameIsValid &&
				this.emailIsValid &&
				this.phoneIsValid &&
				this.msgIsValid
			);
		},
	},
	methods: {
		submitForm() {
			if (this.formIsValid) {
				this.successfulMsg = true;
				this.isPressedBtn = false;
				this.name = null;
				this.email = null;
				this.phone = null;
				this.msg = null;
			} else {
				this.isPressedBtn = true;
				this.successfulMsg = false;
			}
		},
	},
	components: { SectionTitle, SectionDescription, GreenBtn },
};
</script>

<template>
	<section class="contact-form">
		<div class="container contact-form__container">
			<div class="contact-form__content">
				<div class="contact-form__photo">
					<img src="@/assets/img/contact-us.png" alt="goods" />
				</div>
				<form class="contact-form__form" @submit.prevent="submitForm">
					<SectionTitle class="contact-form__title"
						>Get in touch with us</SectionTitle
					>
					<SectionDescription class="contact-form__description"
						>Cras mattis consectetur purus sit amet fermentum. Praesent commodo
						cursus magna, vel scelerisque nisl consectetur
						et.</SectionDescription
					>
					<div class="contact-form__input-rows">
						<div class="field contact-form__input">
							<input
								class="field__input"
								type="text"
								name="name"
								id="name"
								placeholder=""
								v-model="name"
							/>
							<label for="name" class="field__label">Name:</label>
							<p class="error-msg" v-if="!nameIsValid && isPressedBtn">
								The name field is required!
							</p>
						</div>
						<div class="field contact-form__input">
							<input
								class="field__input"
								type="text"
								name="email-2"
								id="email-2"
								placeholder=""
								v-model="email"
							/>
							<label for="email-2" class="field__label">Email:</label>
							<p class="error-msg" v-if="!emailIsValid && isPressedBtn">
								Invalid email
							</p>
						</div>
						<div class="field contact-form__input">
							<input
								class="field__input"
								type="text"
								name="phone-number"
								id="phone-number"
								placeholder=""
								v-model="phone"
							/>
							<label for="phone-number" class="field__label"
								>Phone number:</label
							>
							<p class="error-msg" v-if="!phoneIsValid && isPressedBtn">
								Input phone in next format 1234567890 or 123-345-3456 or
								(078)789-8908
							</p>
						</div>
						<div class="field contact-form__input contact-form__input--msg">
							<textarea
								class="field__input"
								type="text"
								name="msg"
								id="msg"
								placeholder=""
								rows="10"
								v-model="msg"
							></textarea>
							<label for="msg" class="field__label">Your message:</label>
							<p class="error-msg" v-if="!msgIsValid && isPressedBtn">
								Message shoud has more then 1 word
							</p>
						</div>
					</div>
					<GreenBtn class="contact-form__btn">Send</GreenBtn>
					<p class="successful-msg" v-if="successfulMsg">
						Thank you for your response ❤
					</p>
				</form>
			</div>
		</div>
	</section>
</template>

<style lang="scss">
.error-msg {
	position: absolute;
	font-size: 12px;
	bottom: -18px;
	left: 15px;
	color: $color-pale-red;

	&--bigger {
		position: static;
		padding-top: 10px;
		font-size: 14px;
		font-weight: 500;
	}
}

.successful-msg {
	position: absolute;
	padding-top: 10px;
	font-size: 14px;
	font-weight: 500;
	color: $color-main-green;
}

.contact-form {
	&__container {
		@include py(90px);
	}

	&__title {
		text-align: center;
		margin-bottom: 20px;
	}

	&__description {
		text-align: center;
		max-width: 637px;
		margin-bottom: 50px;
	}

	&__content {
		display: flex;
		flex-direction: column;
		align-items: center;
		gap: 50px;
	}

	&__photo {
		@include max-res-width(670px);

		img {
			width: 100%;
			object-fit: fill;
		}
	}

	&__form {
		@include max-res-width(510px);
	}

	&__input-rows {
		display: flex;
		flex-direction: column;
		gap: 28px;
		margin-bottom: 40px;
	}

	&__btn {
		display: block;
		@include max-res-width(160px);
	}

	&__input--msg {
		height: 100px;

		textarea {
			resize: none;
			border-top: 20px solid white;
		}
	}

	.field {
		box-shadow: 0 0 8px 1px rgba(9, 166, 109, 0.3);
	}
}

@media screen and (min-width: $desktop) {
	.contact-form {
		&__content {
			flex-direction: row;
			align-items: flex-start;
			gap: 60px;
			justify-content: space-between;
		}

		&__title,
		&__description {
			text-align: start;
		}
	}
}
</style>
