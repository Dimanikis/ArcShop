<script>
export default {
	data() {
		return {
			tel: '+380998887766',
			address: '1800 Abbot Kinney Blvd. Unit D, Venice',
			email: 'oyasim@email.com',
		};
	},
};
</script>

<template>
	<section class="contacts-links">
		<div class="container contacts-links__container">
			<div class="cont-item">
				<span class="material-symbols-outlined cont-item__icon"> map </span>
				<div class="cont-item__content">
					<span class="cont-item__title">Address</span>
					<address class="cont-item__link">{{ address }}</address>
				</div>
			</div>
			<div class="cont-item">
				<span class="material-symbols-outlined cont-item__icon">
					phone_enabled
				</span>
				<div class="cont-item__content">
					<span class="cont-item__title">Phone</span>
					<a :href="'tel:' + tel" class="cont-item__link">{{ tel }}</a>
				</div>
			</div>
			<div class="cont-item">
				<span class="material-symbols-outlined cont-item__icon"> mail </span>
				<div class="cont-item__content">
					<span class="cont-item__title">Email</span>
					<a :href="'mailto:' + email" class="cont-item__link">{{ email }}</a>
				</div>
			</div>
		</div>
	</section>
</template>

<style lang="scss">
.cont-item {
	display: flex;
	align-items: center;
	gap: 20px;

	&__icon {
		color: $color-main-green;
		font-size: 35px;
	}

	&__title {
		display: block;
		font-size: 14px;
		font-weight: 700;
		text-transform: uppercase;
		margin-bottom: 10px;
	}

	&__link {
		font-size: 14px;
		font-style: normal;
		transition: color 0.3s;
	}

	a:hover {
		color: $color-main-green;
	}
}

.contacts-links {
	&__container {
		border-top: 1px solid rgba(85, 85, 85, 0.2);
		@include py(35px);
		display: flex;
		flex-direction: column;
		align-items: flex-start;
		gap: 50px;
	}
}

@media screen and (min-width: 700px) {
	.contacts-links {
		&__container {
			gap: 0px;
			flex-direction: row;
			align-items: center;
			justify-content: space-between;
		}
	}
}
</style>
