<script>
import StoreList from '../layouts/StoreList.vue';
import SectionTitle from '../SectionTitle.vue';
export default {
	components: {
		StoreList,
		SectionTitle,
	},
};
</script>

<template>
	<section class="feature-pr">
		<div class="container feature-pr__container">
			<SectionTitle class="feature-pr__title">Featured Products</SectionTitle>
			<StoreList :isFeatureProducts="true" />
		</div>
	</section>
</template>

<style lang="scss">
.feature-pr {
	&__container {
		padding-top: 45px;
		padding-bottom: 20px;
	}

	&__title {
		text-align: center;
	}
}
</style>
