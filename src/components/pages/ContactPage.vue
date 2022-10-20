<script>
import InnerHero from '../layouts/InnerHero.vue';
import NewsletterSection from '../layouts/NewsletterSection.vue';
import ContactForm from '../layouts/ContactForm.vue';
import MapSection from '../layouts/MapSection.vue';
import ContactsSection from '../layouts/ContactsSection.vue';
export default {
	components: {
		InnerHero,
		NewsletterSection,
		ContactForm,
		MapSection,
		ContactsSection,
	},
};
</script>

<template>
	<InnerHero :title="'Contact us'"> Contact us</InnerHero>
	<ContactForm />
	<ContactsSection />
	<MapSection />
	<NewsletterSection />
</template>

<style lang="scss"></style>
