<script>
import InnerHero from '../layouts/InnerHero.vue';
import NewsletterSection from '../layouts/NewsletterSection.vue';
import StoreList from '../layouts/StoreList.vue';
export default {
	components: { InnerHero, NewsletterSection, StoreList },
};
</script>

<template>
	<InnerHero :title="'store'"> Store </InnerHero>
	<StoreList />
	<NewsletterSection />
</template>

<style lang="scss"></style>
