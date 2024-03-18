import { render, screen } from '@testing-library/react';
import App from './App';

test('renders learn react link', () => {
  render(<App />);
  const linkElement = screen.getByText(/learn react/i);
  expect(linkElement).toBeInTheDocument()
  expect(linkElement).toBeVisible()
  expect(linkElement).toHaveClass("headline")
});

test('renders Add Button', () => {
  render(<App />);
  // Find the Button
  const addButton = screen.getByRole('button', { name: /add/i });
  expect(addButton).toBeInTheDocument();
  expect(addButton).toBeEnabled();
  expect(addButton).toHaveClass("add-button");
});

test('renders Empty ToDo List initially', () => {
  render(<App />);
  // Find the Empty List Message
  const emptyListMessage = screen.getByText(/no todos yet/i);
  expect(emptyListMessage).toBeInTheDocument();
  expect(emptyListMessage).toBeVisible();
  expect(emptyListMessage).toHaveClass("empty-list-message");
});